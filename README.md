# Doctor Appointments API
This is a simple API that can be used to pre-process and organise medical appointments from the Sesame programming test API.


### Request
`GET localhost:8080/api/v1/doctor/appointments`


###### Description
Reads the data from https://us-central1-sesame-care-dev.cloudfunctions.net/sesame_programming_test_api and transform it into a list of Doctor's Appointments.



### Response Example
```

 {"content": [
        {
            "firstName": "Yessenia",
            "lastName": "Schmitt",
            "appointmentsByLocation": [
                {
                    "locationName": "Kansas City Medical Centre",
                    "appointments": [
                        {
                            "appointmentId": "54edb39d-8357-4ccd-8bc6-0474fa6c5701",
                            "startDateTime": "2021-08-28 03:14:00",
                            "duration": "PT13M",
                            "service": {
                                "name": "Flu shot",
                                "price": 9041
                            }
                        }
                    ]
                },
                {
                    "locationName": "Oklahoma hospital",
                    "appointments": [
                        {
                            "appointmentId": "6b310af6-70da-4af0-b733-77763c2b75f9",
                            "startDateTime": "2021-08-28 03:14:00",
                            "duration": "PT9M",
                            "service": {
                                "name": "Sports physical",
                                "price": 2563
                            }
                        },
                        {
                            "appointmentId": "90d53a93-3cdb-44ad-bd3a-edbe5df616a0",
                            "startDateTime": "2021-08-28 03:14:00",
                            "duration": "PT15M",
                            "service": {
                                "name": "Flu shot",
                                "price": 9041
                            }
                        },
                        {
                            "appointmentId": "b04a6f19-9821-47b2-b7c1-0836d6b5f71f",
                            "startDateTime": "2021-08-28 03:14:00",
                            "duration": "PT15M",
                            "service": {
                                "name": "Sports physical",
                                "price": 2563
                            }
                        }
                    ]
                },
                {
                    "locationName": "Kansas City Care",
                    "appointments": [
                        {
                            "appointmentId": "7e89a213-f57f-4b60-aff7-506fbaf62563",
                            "startDateTime": "2021-08-28 03:14:00",
                            "duration": "PT15M",
                            "service": {
                                "name": "Hip replacement",
                                "price": 1298
                            }
                        },
                        {
                            "appointmentId": "f53d6a53-5614-4d0d-afe8-496ed17ede69",
                            "startDateTime": "2021-08-28 03:14:00",
                            "duration": "PT7M",
                            "service": {
                                "name": "Cardiology consultation",
                                "price": 4689
                            }
                        }
                    ]
                }
            ]
        }],
    "errors": [
        {
            "errorCode": "invalid_location",
            "ids": [
                "039fb99e-6ab2-438c-993a-113fc2668e95",
                "7b84f18d-55d0-4d7a-a35f-f6d437c8a2f4",
                "f9b213bf-87f9-4a42-95c6-0eddcc0a3049",
                "9f765dd3-ceda-426e-a865-47119532bcd7",
                "630b49dc-eb8e-4e6a-81c1-a85aa5de5f45",
                "735069a1-1005-483e-95ce-6da9b2c8390c",
                "0afd7bd1-1291-458e-b99d-78d111a58a8b",
                "30198505-9274-4993-8515-32763d4c17f4",
                "538c3493-9aea-4ea9-ae68-5b8d982bb0ee",
                "2c39b2be-6333-4d61-a1de-9e4292184748",
                "ae7bb484-7a47-4446-aa46-c91838cbb576",
                "971ca265-0c9d-447a-a9e4-4108d1ce4723",
                "7335f1c0-2308-40f0-9f33-d974aa52e1d0",
                "82d0bbf9-1331-4fd4-8bdb-ca84f6f4b1bb",
                "8a371e47-17bc-45a7-aa48-d9db1d7b7827"
            ]
        }
    ]
}

```

The possible types of errors are:

- invalid_doctor: the doctor first or last name are null.
- invalid_duration_in_minutes: the duration in minutes is 0
- invalid_service: the service price is 0 or the service name is null
- invalid_location: the location name or timeZoneCode are null
- invalid_id: the id is null
- invalid_time: the time is null


### API Components

The Following diagram roughly illustrates how the API works.

![APFlow](https://user-images.githubusercontent.com/8027371/131234481-139ccf94-8c5c-4f52-beb0-d6ac1c87500b.png)


Basically, when the `GET localhost:8080/api/v1/doctor/appointments` endpoint is called, the HTTP GET Request to https://us-central1-sesame-care-dev.cloudfunctions.net/sesame_programming_test_api is performed. 

The **AppointmentsService** then reads and parses the JSON data and creates a list of `Appointment` objects that are stored in memory. 

At the same time, the non-valid `Appointments` (the ones that have any missing field) are sent to the **AppointmentErrorService** to create an `AppointmentError` for this appointment.

Once all the `Appointment`s are created, the `APIResponse` will be created by calling both the **AppointmentErrorService** to get all the `AppointmentErrors` and the **DoctorAppointmentsService** to obtain all the `DoctorAppointments`. 

To get a better idea of this classes, you can take a look at this other diagram

![Classes](https://user-images.githubusercontent.com/8027371/131234575-642cb362-9868-43d6-943f-9d857f14ea31.png)

The only thing left to mention is the algorithm that transform the `Appointment` into a `DoctorAppointment`. Let's do it 🚀 

For each `Appointment`, we check if we already have a `DoctorAppointment` entry for the `Doctor` of this `Appointment`.

If we don't, then everything is great and we just have to create an new `DoctorAppointment` entry for this `Appointment`.

If we do, then we have to update this Doctor's record, by adding a new `AppointmentByLocation` entry if we don't have an entry for this location, or just a `ShortAppointment` entry if we already have the location as well.


### Room for improvement

Here is some stuff that would be nice to fix or add.

- `startDateTime` should be ISO Date, and it should take into account the timeZoneCode.
- `duration` should be an ISO Duration. Maybe there is some library to transform from minutes to this format.
- Take a closer look to error handling, exception throwing and catching, and also logging.


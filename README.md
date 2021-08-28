# Doctor Appointments API
API that cleans up and restructures Doctor's appointments data.

### Request
`GET localhost:8080/api/v1/doctor/appointments`

###### Description
Reads the data from https://us-central1-sesame-care-dev.cloudfunctions.net/sesame_programming_test_api (at the moment, that data is downloaded locally and read it from a File) and transform it into a list of Doctor's Appointments.

### Response
```

[
    {
        "firstName": "Chanelle",
        "lastName": "Gerhold",
        "appointmentsByLocation": [
            {
                "locationName": "Wichita rehabilitation center",
                "appointments": [
                    {
                        "appointmentId": "0fa0ce48-9417-4443-b495-93a7c0f270ae",
                        "startDateTime": "2021-08-25 11:06:00",
                        "duration": "PT10M",
                        "service": {
                            "name": "Physiotherapy consultation",
                            "price": 3303
                        }
                    },
                    {
                        "appointmentId": "e9f77f2a-200c-4ce1-bb69-bee3f32416f1",
                        "startDateTime": "2021-08-25 11:06:00",
                        "duration": "PT15M",
                        "service": {
                            "name": "Discolored butthole flaps inspection",
                            "price": 2778
                        }
                    }
                ]
            },
            {
                "locationName": "Oklahoma hospital",
                "appointments": [
                    {
                        "appointmentId": "a70ad41d-6b80-46ce-8077-a93cb5da5a7c",
                        "startDateTime": "2021-08-25 11:06:00",
                        "duration": "PT12M",
                        "service": {
                            "name": "Discolored butthole flaps inspection",
                            "price": 2778
                        }
                    }
                ]
            },
            {
                "locationName": "Kansas City Care",
                "appointments": [
                    {
                        "appointmentId": "c0780186-ad8c-469e-8c5b-4034b4bde07a",
                        "startDateTime": "2021-08-25 11:06:00",
                        "duration": "PT5M",
                        "service": {
                            "name": "MRI Scan",
                            "price": 9770
                        }
                    }
                ]
            },
            {
                "locationName": "Kansas City Medical Centre",
                "appointments": [
                    {
                        "appointmentId": "515089a6-c8b1-44af-966f-161d90003303",
                        "startDateTime": "2021-08-25 11:06:00",
                        "duration": "PT11M",
                        "service": {
                            "name": "Sports physical",
                            "price": 4951
                        }
                    },
                    {
                        "appointmentId": "9401397a-35ef-4cba-a57b-4f534e803a1a",
                        "startDateTime": "2021-08-25 11:06:00",
                        "duration": "PT13M",
                        "service": {
                            "name": "X-Ray",
                            "price": 1221
                        }
                    }
                ]
            }
        ]
    }
]
    
```

### Request
`GET localhost:8080/api/v1/doctor/appointmentsapi/v1/error/appointments`

###### Description
Returns a list of errors and for each one, the appointments that contained that error and were not processed because of that.

### Response

```

[
    {
        "errorCode": "invalid_location",
        "ids": [
            "0d302304-e42c-4339-bcca-0c19fd0afff7",
            "2c7cce47-e475-4e02-9d3c-4d775f80602c",
            "badefdd9-cfe4-435b-af33-a2e3dea6d258"
        ]
    }
]

```

The possible types of errors are:

- invalid_doctor
- invalid_duration_in_minutes
- invalid_service
- invalid_location
- invalid_id
- invalid_time

package com.sesame.appointments.api;
import com.sesame.appointments.service.AppointmentsService;
import com.sesame.appointments.service.DoctorAppointmentsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static junit.framework.TestCase.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DoctorAppointmentsController.class)
@MockBeans({@MockBean(DoctorAppointmentsService.class), @MockBean(AppointmentsService.class)})
public class DoctorAppointmentsControllerIntTest {
    @Autowired
    DoctorAppointmentsService doctorAppointmentsService;

    @Autowired
    AppointmentsService appointmentsService;

    @Autowired
    private MockMvc mvc;

    @Test
    void getAll() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/doctor/appointments");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(result.getResponse().getStatus(), 200);
    }

}

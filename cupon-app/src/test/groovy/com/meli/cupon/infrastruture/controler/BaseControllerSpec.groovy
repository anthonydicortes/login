package com.meli.cupon.infrastruture.controler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@EnableAutoConfiguration
@AutoConfigureMockMvc
@ContextConfiguration(classes = [BaseController])
class BaseControllerSpec extends Specification {

    @Autowired
    MockMvc mockMvc

    def "Respuesta 200 OK es retornada cuando el servicio del cupon retorna una lista de compras sugerida"() {
        given: "una lista de productos favoritos y un cupon"

//        def body = ResourceFileReader.getFileContentAsString("__files/postCouponEndpoint/postCouponRequestBody.json")

        expect:
        def result = mockMvc.perform(post("/base")
//                .content(body)
                .header(HttpHeaders.CONTENT_TYPE, "application/json"))
                .andExpect(request().asyncStarted())
                .andReturn()

        mockMvc.perform(asyncDispatch(result))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath('$.item_ids').isArray())
//                .andExpect(MockMvcResultMatchers.jsonPath('$.item_ids', hasSize(3)))
//                .andExpect(MockMvcResultMatchers.jsonPath('$.item_ids[0]', is("MLA1")))
//                .andExpect(MockMvcResultMatchers.jsonPath('$.item_ids[1]', is("MLA2")))
//                .andExpect(MockMvcResultMatchers.jsonPath('$.item_ids[2]', is("MLA3")))
//                .andExpect(MockMvcResultMatchers.jsonPath('$.total', is(480.25)))
    }
}

package net.zamora;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AppTests {

	@Autowired
	private MockMvc mockMvc;

	/* TEST CASE 1
	 *
	 * Petición a las 10:00 del día 14 del producto 35455   para la brand 1 (Tienda)
	 *
	 * Request:
	 * /prices/1/35455/2020-06-14 10:00:00
	 *
	 * Expected Response:
	 * {
	 *    "productId":35455,
	 *    "brandId":1,
	 *    "priceList":1,
	 *    "startDate": "2020-06-14T00:00:00Z",
     *    "endDate": "2020-12-31T23:59:59Z",
	 *    "price":35.5
	 * }
	 */
	@Test
	public void testCase1() throws Exception {

		this.mockMvc.perform(get("/prices/1/35455/2020-06-14 10:00:00")
				.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00Z"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59Z"))
				.andExpect(jsonPath("$.price").value(35.5));
	}

	/* TEST CASE 2
	 *
	 * Petición a las 16:00 del día 14 del producto 35455   para la brand 1 (Tienda)
	 *
	 * Request:
	 * /prices/1/35455/2020-06-14 16:00:00
	 *
	 * Expected Response:
	 * {
	 *    "productId":35455,
	 *    "brandId":1,
	 *    "priceList":2,
	 *    "startDate": "2020-06-14T15:00:00Z",
     *    "endDate": "2020-06-14T18:30:00Z",
	 *    "price":25.45
	 * }
	 */
	@Test
	public void testCase2() throws Exception {

		this.mockMvc.perform(get("/prices/1/35455/2020-06-14 16:00:00")
				.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.priceList").value(2))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00Z"))
				.andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00Z"))
				.andExpect(jsonPath("$.price").value(25.45));
	}

	/* TEST CASE 3
	 *
	 * Petición a las 21:00 del día 14 del producto 35455   para la brand 1 (Tienda)
	 *
	 * Request:
	 * /prices/1/35455/2020-06-14 21:00:00
	 *
	 * Expected Response:
	 * {
	 *    "productId":35455,
	 *    "brandId":1,
	 *    "priceList":1,
	 *    "startDate": "2020-06-14T00:00:00Z",
	 *    "endDate": "2020-12-31T23:59:59Z",
	 *    "price":35.5
	 * }
	 */
	@Test
	public void testCase3() throws Exception {

		this.mockMvc.perform(get("/prices/1/35455/2020-06-14 21:00:00")
				.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00Z"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59Z"))
				.andExpect(jsonPath("$.price").value(35.5));
	}

	/* TEST CASE 4
	 *
	 * Petición a las 10:00 del día 15 del producto 35455   para la brand 1 (Tienda)
	 *
	 * Request:
	 * /prices/1/35455/2020-06-15 10:00:00
	 *
	 * Expected Response:
	 * {
	 *    "productId":35455,
	 *    "brandId":1,
	 *    "priceList":3,
	 *    "startDate": "2020-06-15T00:00:00Z",
	 *    "endDate": "2020-06-15T11:00:00Z",
	 *    "price":30.5
	 * }
	 */
	@Test
	public void testCase4() throws Exception {

		this.mockMvc.perform(get("/prices/1/35455/2020-06-15 10:00:00")
				.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.priceList").value(3))
				.andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00Z"))
				.andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00Z"))
				.andExpect(jsonPath("$.price").value(30.5));
	}

	/* TEST CASE 5
	 *
	 * Petición a las 21:00 del día 16 del producto 35455   para la brand 1 (Tienda)
	 *
	 * Request:
	 * /prices/1/35455/2020-06-16 21:00:00
	 *
	 * Expected Response:
	 * {
	 *    "productId":35455,
	 *    "brandId":1,
	 *    "priceList":4,
	 *    "startDate": "2020-06-15T16:00:00Z",
	 *    "endDate": "2020-12-31T23:59:59Z",
	 *    "price":38.95
	 * }
	 */
	@Test
	public void testCase5() throws Exception {

		this.mockMvc.perform(get("/prices/1/35455/2020-06-16 21:00:00")
				.contentType("application/json"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.priceList").value(4))
				.andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00Z"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59Z"))
				.andExpect(jsonPath("$.price").value(38.95));
	}

}

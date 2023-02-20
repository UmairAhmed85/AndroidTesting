import retrofit2.Response
import retrofit2.http.*

interface ProductsApi {

    @GET("/products")
    suspend fun getProducts() : Response<List<ProductModel>>
}
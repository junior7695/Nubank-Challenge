package co.com.nubank.mobile.challenge.infrastructure.core.data_source.remote

import co.com.nubank.mobile.challenge.TestMainApplication
import co.com.nubank.mobile.challenge.di.component.DaggerTestAppComponent
import co.com.nubank.mobile.challenge.di.component.TestAppComponent
import co.com.nubank.mobile.challenge.infrastructure.api.service.ApiService
import co.com.nubank.mobile.challenge.infrastructure.core.data_source.DataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class RemoteDataSourceImplTest {

    private lateinit var remoteDataSource: DataSource

    @Inject
    internal lateinit var apiService: ApiService

    @Before
    fun setup() {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(TestMainApplication())
        component.inject(this)

        remoteDataSource = RemoteDataSourceImpl(apiService)
    }

    @Test
    fun `getLinkByAlias, when alias is 111111 should return status code 200 with expected url`() {
        runBlocking {
            // When
            val result = remoteDataSource.getLinkByAlias("111111")

            // Then
            Assert.assertEquals(200, result.code())

            Assert.assertNotNull(result.body())

            Assert.assertEquals("https://www.youtube.com/", result.body()?.url)
        }
    }

    @Test
    fun `postShortLink, should return status code 200 with expected body`() {
        runBlocking {
            // When
            val result =
                remoteDataSource.postShortLink("https://www.youtube.com/")

            // Then
            Assert.assertEquals(200, result.code())

            Assert.assertNotNull(result.body())

            Assert.assertEquals("111111", result.body()?.alias)

            Assert.assertEquals("https://www.youtube.com/", result.body()?.links?.self)

            Assert.assertEquals(
                "https://url-shortener-nu.herokuapp.com/short/111111",
                result.body()?.links?.short
            )
        }
    }
}
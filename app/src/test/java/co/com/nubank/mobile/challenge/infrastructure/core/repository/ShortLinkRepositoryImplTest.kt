package co.com.nubank.mobile.challenge.infrastructure.core.repository


import co.com.nubank.mobile.challenge.TestMainApplication
import co.com.nubank.mobile.challenge.di.component.TestAppComponent
import co.com.nubank.mobile.challenge.di.component.DaggerTestAppComponent
import co.com.nubank.mobile.challenge.infrastructure.api.dtos.response.GetShortLinkResponseDTO
import co.com.nubank.mobile.challenge.infrastructure.api.dtos.response.LinksDTO
import co.com.nubank.mobile.challenge.infrastructure.api.dtos.response.PostShortLinkResponseDTO
import co.com.nubank.mobile.challenge.infrastructure.core.data_source.DataSource
import co.com.nubank.mobile.challenge.infrastructure.core.converters.Result
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import javax.inject.Inject

class ShortLinkRepositoryImplTest {

    private lateinit var repository: ShortLinkRepository

    @Inject
    internal lateinit var remoteDataSource: DataSource

    @Before
    fun setup() {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(TestMainApplication())
        component.inject(this)

        repository = ShortLinkRepositoryImpl(remoteDataSource)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `getLinkByAlias, should call getLinkByAlias by remoteDataSource`() {
        runBlockingTest {
            // Given
            val alias = "111111"

            val urlMock = "https://www.youtube.com/"

            val responseMock = Response.success(GetShortLinkResponseDTO(urlMock))

            coEvery { remoteDataSource.getLinkByAlias(alias) } returns responseMock

            // When
            val result = repository.getLinkByAlias(alias) as Result.Success

            // Then
            coVerify { remoteDataSource.getLinkByAlias(alias) }

            Assert.assertEquals(Result.Success::class, result::class)

            Assert.assertEquals(urlMock, result.data)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `postShortLink, should call postShortLink by remoteDataSource`() {
        runBlockingTest {
            // Given
            val url = "https://www.youtube.com/"

            val bodyMock = PostShortLinkResponseDTO(
                "111111",
                LinksDTO(
                    "https://www.youtube.com/",
                    "https://url-shortener-nu.herokuapp.com/short/111111"
                )
            )

            val responseMock = Response.success(bodyMock)

            coEvery { remoteDataSource.postShortLink(url) } returns responseMock

            // When
            val result = repository.postShortLink(url) as Result.Success

            // Then
            coVerify { remoteDataSource.postShortLink(url) }

            Assert.assertEquals(Result.Success::class, result::class)

            Assert.assertEquals(bodyMock.alias, result.data.getAlias())

            Assert.assertEquals(bodyMock.links.self, result.data.getSelfLink())

            Assert.assertEquals(bodyMock.links.short, result.data.getShortLink())
        }
    }
}
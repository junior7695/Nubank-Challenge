package co.com.nubank.mobile.challenge.infrastructure.core.repository


import co.com.nubank.mobile.challenge.application.TestMainApplication
import co.com.nubank.mobile.challenge.di.component.TestAppComponent
import co.com.nubank.mobile.challenge.di.component.DaggerTestAppComponent
import co.com.nubank.mobile.challenge.infrastructure.core.data_source.DataSource
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import javax.inject.Inject

class ShortLinkRepositoryImplTest {

    @Inject
    internal lateinit var repository: ShortLinkRepositoryImpl

    @Inject
    internal lateinit var remoteDataSource: DataSource

    @Before
    fun setup() {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(TestMainApplication())
        component.inject(this)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `getPosts, should call getPosts by remoteDataSource`() = runBlockingTest {
        // Given
//        val postList = mutableListOf<Post>()
//
//        val post = Post(1234, "test", Author(1234, "junior7695"), "test description", false, 1, 1)
//
//        postList.add(post)
//
//        val responseDTO = RepositoriesGitHubDTO(1, postList)
//
//        val responseRetrofit = Response.success(responseDTO)
//
//        coEvery { remoteDataSource.getPosts("kotlin", 1, 1) } returns responseRetrofit
//
//        // When
//        repository.getPosts("kotlin", 1, 1)
//
//        // Then
//        coVerify { remoteDataSource.getPosts("kotlin", 1, 1) }
    }
}
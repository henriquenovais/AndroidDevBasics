@RunWith(RobolectricTestRunner::class)
@Config(sdk = Build.VERSION_CODES.R)
class FileTest {

    // region Constants

    //endregion Constants

    //region Helper fields

    //endregion Helper fields

    var SUT : File

    init {
        //initial setup here
        SUT = new File()
        mFileMock = mock(File::class.java)
    }

    @Test
    fun `SUT is not null`() {
        //Arrange
        //Act
        //Assert
        assertNotNull(SUT)
    }
}
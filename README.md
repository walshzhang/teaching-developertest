# teaching-developertest
provide some examples about developer test used in my teaching.
it plans to contain following subprojects.

## junit-core
* v0.1
    * assertion. including assertThat
    * @Test. including expected exception test.
* v0.2
    * @Before. test fixture.
* v0.3
    * @RunWith(Theories.class)
    * @Theory
    * @DataPoints and @FromDataPoints
* v0.5
    * @Rule
        * UsingExceptedExceptionRuleTest
        * UsingTemporaryFolderRuleTest
        * Logger is a custom rule named . when this rule is used, 
        it will log the test information to a specified file.
        * Files provides some file operation such as read and write.
        * FilesTest uses Logger and TemporaryFolder rule. 

## mockito-core

## hamcrest-matchers
* v0.4 add three hamcrest matchers used to assert properites of a Money object in JUnit test.
package org.example;

public class Settings {
    static final String TEST_NG_METHOD_FILE_TEMPLATE = """
            <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
            <suite name="Suite" thread-count="12" parallel="methods">
                <test name="Test">
                    <classes>
                        <class name="%CLASS_NAME%">
                            <methods>
                                <include name="%METHOD_NAME%" />
                            </methods>
                        </class>
                        <class name="org.example.CommonTest"/>
                    </classes>
                </test> <!-- Test -->
            </suite> <!-- Suite -->
            """;
    static final String CLASS_NAME_PLACEHOLDER = "%CLASS_NAME%";
    static final String METHOD_NAME_PLACEHOLDER = "%METHOD_NAME%";
}

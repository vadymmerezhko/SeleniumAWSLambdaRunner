package org.example;

public class Settings {
    static final String TEST_NG_METHOD_FILE_TEMPLATE =
            "<!DOCTYPE suite SYSTEM \"https://testng.org/testng-1.0.dtd\">\n" +
            " <suite name=\"Suite\" thread-count=\"1\" parallel=\"methods\">\n" +
            "    <test name=\"Test\">\n" +
            "        <classes>\n" +
            "            <class name=\"%CLASS_NAME%\">\n" +
            "                <methods>\n" +
            "                    <include name=\"%METHOD_NAME%\" />\n" +
            "                </methods>\n" +
            "            </class>\n" +
            "            <class name=\"org.example.CommonTest\"/>\n" +
            "        </classes>\n" +
            "    </test> <!-- Test -->\n" +
            "</suite> <!-- Suite -->;\n";
    static final String CLASS_NAME_PLACEHOLDER = "%CLASS_NAME%";
    static final String METHOD_NAME_PLACEHOLDER = "%METHOD_NAME%";

    ////////////////////////////////////////////////////////////////////////

    static public final int DEFAULT_THREADS_COUNT = 4;
}

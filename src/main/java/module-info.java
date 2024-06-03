module com.example.aitest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    requires lombok;
    requires org.json;

    opens com.example.aitest to javafx.fxml;
    exports com.example.aitest;
    exports com.response.data;
    opens com.response.data to javafx.fxml, com.google.gson;
    opens com.tools to com.google.gson;
    // Add this line
}

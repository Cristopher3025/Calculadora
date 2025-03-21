module ceuv.calculadorafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens ceuv.calculadorafx to javafx.fxml;
    exports ceuv.calculadorafx;
}

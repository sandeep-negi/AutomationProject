package qa.constants;

public enum EndPoint {
    API_SIGN_IN("/users/sign_in.json?source=Class Login&send_to_mixpanel=true"),
    TEACHER_DASHBOARD("/teacher/dashboard"),
    SCHOOL_SERVICE_PROFILE("/school-service/api/v1/teachers/profile"),
    ADD_NEW_KLASS("school-service/api/v1/klasses"),
    SIGN_IN_PAGE("/signin");

    public String url ;

    EndPoint(String url) {
        this.url = url ;
    }
}

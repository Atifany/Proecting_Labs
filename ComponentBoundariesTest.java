// Внимание, данный код является примером

@AnalyzeClasses(packages = "com.myapp")
public class ComponentBoundariesTest {

    @ArchTest
    static final ArchRule processing_must_not_depend_on_web =
            noClasses()
                    .that().resideInAPackage("com.myapp.processing..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("com.myapp.web..");

    @ArchTest
    static final ArchRule events_must_not_depend_on_processing_or_db =
            noClasses()
                    .that().resideInAPackage("com.myapp.events..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage(
                            "com.myapp.processing..",
                            "com.myapp.analyticsdb.."
                    );
}
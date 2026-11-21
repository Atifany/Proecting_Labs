// Внимание, данный код является примером

@AnalyzeClasses(packages = "com.myapp")
public class CycleDependencyTest {

    @ArchTest
    static final ArchRule no_cycles =
            slices()
                    .matching("com.myapp.(*)..")
                    .should().beFreeOfCycles();
}
public class AssessorFactory
{
    public Accessor createAssessorFactory(String string) {
        if (string == "Demo") {
            return new DemoPresentation();
        } else
        {
            return new XMLAccessor();
        }
    }
}

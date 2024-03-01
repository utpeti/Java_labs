import java.util.ArrayList;
import java.util.List;

public interface Strategy {

    public ArrayList<Student> processFile(String fileName);
    public void printStatistics(List<Student> students);
}

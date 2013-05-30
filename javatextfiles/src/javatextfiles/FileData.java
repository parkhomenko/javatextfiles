package javatextfiles;

import java.util.Map;

public interface FileData {
    
    public Map getData(String fileName);
    public void writeData(String fileName, Map map);
    
}
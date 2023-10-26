package helpers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CmdCommandRunner {

    public CmdCommandRunner(){
        super();
    }
    private Runtime runtime = Runtime.getRuntime();

    public CdmResult runCommand(String[] command) {
        CdmResult result = new CdmResult();
        try {
            Process proc = runtime.exec(command);
            readStream(proc.getInputStream(),result.getOut());
            readStream(proc.getInputStream(),result.getErr());
            proc.getOutputStream().close();
            return result;
        }catch (Exception e){
            return result;
        }
    }

    private void readStream(InputStream inputStream, List<String> outPut){
        String line;
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader= new BufferedReader(inputStreamReader);){
            while ((line= bufferedReader.readLine())!=null) {
                outPut.add(line);
                System.out.println(line);
                if (line.contains("INFO")) {
                    break;
                }
            }
        }catch (Exception e){
        }
    }
}

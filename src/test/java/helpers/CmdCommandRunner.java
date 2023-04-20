package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CmdCommandRunner {

    public CmdCommandRunner(){
        super();
    }
    private Runtime runtime = Runtime.getRuntime();

    public CdmResult runCommand(String command) {
        try {
            Process proc = runtime.exec(command);
            proc.getOutputStream().close();

            CdmResult result = new CdmResult();
            readStream(proc.getInputStream(),result.getOut());
            readStream(proc.getInputStream(),result.getErr());

            return result;

        }catch (Exception e){
            return null;
        }
    }

    private void readStream(InputStream inputStream, List<String> outPut) throws IOException {
        String line;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
        while ((line= bufferedReader.readLine())!=null){
            outPut.add(line);
            System.out.println(line);
            if (line.equalsIgnoreCase("INFO    | Boot completed")){
                break;
            }
        }
        inputStreamReader.close();
        bufferedReader.close();
    }
}

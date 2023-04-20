package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CdmResult {
    private List<String> out = new ArrayList<>();
    private List<String> err = new ArrayList<>();

    public CdmResult(){
       super();
    }

    public List<String> getOut() {
        return out;
    }

    public List<String> getErr() {
        return err;
    }

    public boolean hasErr(){
        return err.size() > 0;
    }

    public String outPutError(){
       return  err.stream().map(error->error +"\n").collect(Collectors.joining());
    }

    @Override
    public String toString() {
        return out.stream().map(outPut->outPut+"\n").collect(Collectors.joining());
    }
}

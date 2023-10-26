import helpers.CmdCommandRunner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CmdCommandRunner cmdCommandRunner = new CmdCommandRunner();
        String[] bla = {"sh","-c"," open -a Simulator && xcrun simctl boot 'iPhone 14'"};
        System.out.println(cmdCommandRunner.runCommand(bla));
//        String[] bla1 = {"sh","-c","emulator @Pixel_2_API_30"};
//        System.out.println(cmdCommandRunner.runCommand(bla1));

//        System.out.println(cmdCommandRunner.runCommand(""));
        String[] bla2= {"sh","-c","xcrun simctl list devices | grep \"iPhone 14\""};
        String deviceLine;
        do {
            deviceLine = cmdCommandRunner.runCommand(bla2).toString();
        } while(!deviceLine.contains("Booted"));

    }
}
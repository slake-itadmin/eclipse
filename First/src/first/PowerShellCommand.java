package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerShellCommand {

	public static void main(String[] args) throws IOException {
		String user_email = "edmundchiu@silverglobe.com";
		String full_name_script = "powershell.exe  \"C:\\Users\\PNCHIU\\OneDrive\\Work\\PowerShell\\PasswordPortal\\id_name.ps1 " + user_email + "\" ";
		Process powerShellProcess = Runtime.getRuntime().exec(full_name_script);
		// Getting the results
		powerShellProcess.getOutputStream().close();
		String result;
		System.out.println("Standard Output:");
		BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
		while ((result = stdout.readLine()) != null) {
			System.out.println(result);
		}
		stdout.close();
	}
}
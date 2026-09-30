import java.util.Scanner;
 public class CRCProgram {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 // Input original message
 System.out.print("Enter the no of bits in the message : ");
 int msgBits = sc.nextInt();
 int[] message = new int[msgBits];
 System.out.print("Enter the message bits : ");
 for (int i = 0; i < msgBits; i++) {
 message[i] = sc.nextInt();
 }
 // Input generator polynomial
 System.out.print("Enter the no of bits generated : ");
 int genBits = sc.nextInt();
 int[] generator = new int[genBits];
 System.out.print("Enter the generated bits : ");
 for (int i = 0; i < genBits; i++) {
 generator[i] = sc.nextInt();
 }
 // Make space for appended message
 int[] appendedMsg = new int[msgBits + genBits - 1];
 System.arraycopy(message, 0, appendedMsg, 0, msgBits);
 // Copy for division
 int[] remainder = new int[appendedMsg.length];
 System.arraycopy(appendedMsg, 0, remainder, 0, appendedMsg.length);
 // CRC Division
 for (int i = 0; i < msgBits; i++) {
 if (remainder[i] == 1) {
 for (int j = 0; j < genBits; j++) {
 remainder[i + j] ^= generator[j];
 }
 }
 }
// Attach CRC remainder to original message
 int[] transmittedMsg = new int[msgBits + genBits - 1];
 System.arraycopy(message, 0, transmittedMsg, 0, msgBits);
 for (int i = 0; i < genBits - 1; i++) {
 transmittedMsg[msgBits + i] = remainder[msgBits + i];
 }
 System.out.print("Generated bits : ");
 for (int i = 0; i < genBits - 1; i++) {
 System.out.print(remainder[msgBits + i] + " ");
 }
 System.out.println();
 System.out.print("Appended message : ");
 for (int i : transmittedMsg) {
 System.out.print(i + " ");
 }
 System.out.println();
 System.out.print("Transmitted message from transmitter : ");
 for (int i : transmittedMsg) {
 System.out.print(i + " ");
 }
 System.out.println();
 // Simulate received message
 System.out.print("Message of 20 bits received : ");
 int[] received = new int[transmittedMsg.length];
 for (int i = 0; i < received.length; i++) {
 received[i] = sc.nextInt();
 }
 // CRC check
 int[] check = new int[received.length];
 System.arraycopy(received, 0, check, 0, received.length);
 for (int i = 0; i < msgBits; i++) {
 if (check[i] == 1) {
 for (int j = 0; j < genBits; j++) {
 check[i + j] ^= generator[j];
 }
 }
}
 boolean error = false;
 for (int i = msgBits; i < check.length; i++) {
 if (check[i] != 0) {
 error = true;
 break;
 }
 }
 if (error)
 System.out.println("There is an error");
 else
 System.out.println("There is no error");
 sc.close();
 }
}
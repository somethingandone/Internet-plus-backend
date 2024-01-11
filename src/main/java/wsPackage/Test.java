package wsPackage;

import java.util.List;

public class Test {
  public static void main(String[] argv){
    BankPolicyWebServiceImplService bankPolicyWebServiceImplService = new BankPolicyWebServiceImplService();
    BankPolicyService bankPolicyService = bankPolicyWebServiceImplService.getBankPolicyWebServiceImplPort();
    InRegulation inRegulation = bankPolicyService.inRegulationGetById("65642eacb7fe9e690a7849ad");
    System.out.println(inRegulation.title);
    List<InRegulation> list = bankPolicyService.inRegulationList();
    for (InRegulation regulation : list) {
      System.out.println(regulation.title);
    }
    int count = bankPolicyService.inRegulationCount(inRegulation);
    System.out.println(count);
  }
}

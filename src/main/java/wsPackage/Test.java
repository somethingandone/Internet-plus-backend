package wsPackage;

import java.util.List;

public class Test {
  public static void main(String[] argv){
    BankPolicyWebServiceImplService bankPolicyWebServiceImplService = new BankPolicyWebServiceImplService();
    BankPolicyService bankPolicyService = bankPolicyWebServiceImplService.getBankPolicyWebServiceImplPort();
    //内归
    InRegulation inRegulation = bankPolicyService.inRegulationGetById("65642eacb7fe9e690a7849ad");
    System.out.println(inRegulation.title);
    List<InRegulation> list = bankPolicyService.inRegulationList();
    for (InRegulation regulation : list) {
      System.out.println(regulation.title);
    }
    int count = bankPolicyService.inRegulationCount(inRegulation);
    System.out.println(count);
    //外归
    ExRegulation exRegulation = bankPolicyService.exRegulationGetById("6561e924c1e12dc3a62df122");
    System.out.println(exRegulation.title);
    List<ExRegulation> exRegulationList = bankPolicyService.exRegulationList();
    for (ExRegulation regulation : exRegulationList) {
      System.out.println(regulation.title);
    }
    int exRegulationCount = bankPolicyService.exRegulationCount(exRegulation);
    System.out.println(exRegulationCount);
  }
}

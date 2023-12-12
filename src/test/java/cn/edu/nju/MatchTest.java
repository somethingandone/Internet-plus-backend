package cn.edu.nju;

import cn.edu.nju.model.VO.MatchItem;
import cn.edu.nju.model.VO.RegulationRetrievalVO;
import cn.edu.nju.service.RegulationMatchService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class MatchTest extends Tester{
    @Resource
    RegulationMatchService regulationMatchService;

    @Test
    public void test1() throws Exception {
        RegulationRetrievalVO regulationRetrievalVO = RegulationRetrievalVO.builder()
                .title("中国银保监会就《理财公司内部控制管理办法（征求意见稿）》公开征求意见")
                .text("为贯彻落实党中央、国务院关于加强金融法治建设的重要部署，推动理财公司依法合规经营和持续稳健运行，按照诚实信用、勤勉尽责原则切实履行受托管理职责，根据《中华人民共和国银行业监督管理法》《关于规范金融机构资产管理业务的指导意见》等法律法规，中国银保监会制定《理财公司内部控制管理办法》（以下简称《办法》），自2022年4月29日起公开征求意见。《办法》对《关于规范金融机构资产管理业务的指导意见》《商业银行理财业务监督管理办法》《商业银行理财子公司管理办法》等法规的原则性要求进行细化和补充，与上述制度共同构成理财公司内控管理的根本遵循。《办法》共六章41条，分别为总则、内部控制职责、内部控制活动、内部控制保障、内部控制监督及附则。《办法》坚持问题导向、行业对标和风险底线原则，要求理财公司建立全面、制衡、匹配和审慎的内控管理机制和组织架构，完善投资管理分级授权机制，健全交易制度全流程管理，加强重要岗位关键人员全方位管理，强化关联交易管理与风险隔离，充分发挥内控职能部门和内审部门的内部监督作用。监管部门应坚持为民监管理念，加强持续监管，逐步建立理财公司评价体系，提升监管有效性。《办法》是理财行业迈向高质量发展的重要制度保障。发布实施《办法》有利于统一同类资管业务监管标准，增强理财公司法治观念和合规意识，促进构建与自身业务规模、特点和风险状况相适应的内控合规管理体系，推动理财行业形成良好发展生态。下一步，银保监会将做好《办法》征求意见工作，持续督促理财公司强化内控合规管理建设，提高经营管理质效，增强风险防范能力，促进理财业务规范健康和可持续发展。附：中国银保监会关于《理财公司内部控制管理办法（征求意见稿）》公开征求意见的公告http://www.cbirc.gov.cn/cn/view/pages/ItemDetail.html?docId\\u003d1049374\\u0026itemId\\u003d951\\u0026generaltype\\u003d2")
                .build();
        List<MatchItem> matchItems = regulationMatchService.retrieval(regulationRetrievalVO);
        matchItems.forEach(System.out::println);
    }
}

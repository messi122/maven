package cn.comico.controller;


import cn.comico.facade.CodeApi;
import cn.comico.params.CodeGenerator;
import cn.comico.supply.facade.CodeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName CodeController
 * @Description TODO
 * @date 2018/7/23 18:25
 **/
@RestController
public class CodeController implements CodeApi {

    @Autowired
    private CodeGenerator codeGenerator;

    @Override
    public String generateSaleCode() {
        return codeGenerator.generateSaleCode();
    }

    @Override
    public String generateCGCode() {
        return codeGenerator.generateCGCode();
    }

    @Override
    public String generateRKCode() {
        return codeGenerator.generateRKCode();
    }

    @Override
    public String generatePHCode() {
        return codeGenerator.generatePHCode();
    }

    @Override
    public String generateJHCode(Long channelId) {
        return codeGenerator.generateJHCode(channelId);
    }

    @Override
    public String generateTHCode() {
        return codeGenerator.generateTHCode();
    }
}

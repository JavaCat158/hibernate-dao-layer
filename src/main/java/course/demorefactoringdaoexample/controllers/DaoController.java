package course.demorefactoringdaoexample.controllers;

import course.demorefactoringdaoexample.repository.DaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DaoController {
    private final DaoRepository daoRepository;

    @Autowired
    public DaoController(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> retName(@RequestParam String name) {
        return daoRepository.getProductName(name);
    }
}


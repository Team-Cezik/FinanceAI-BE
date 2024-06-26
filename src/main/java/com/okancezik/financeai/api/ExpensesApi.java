package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.DataResult;
import com.okancezik.financeai.core.utils.results.SuccessDataResult;
import com.okancezik.financeai.service.abstracts.ExpenseService;
import com.okancezik.financeai.service.dto.responses.ListExpenseResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expense")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class ExpensesApi {

    private final ExpenseService service;

    @GetMapping
    public DataResult<List<ListExpenseResponseModel>> getAll(@RequestParam int id){
        var data = this.service.getAllExpensesByUser(id);
        return new SuccessDataResult<>(data,"Listed expenses");
    }
}

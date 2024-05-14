package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.repository.abstracts.CommentRepository;
import com.okancezik.financeai.service.abstracts.CommentService;
import com.okancezik.financeai.service.dto.responses.ListCommentResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentManager implements CommentService {

    private final CommentRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public List<ListCommentResponseModel> getAllCommentsByLot(int id) {
        var data = this.repository.findByLotId(id);
        return data.stream().map(x->this.mapperService.forResponse()
                .map(x,ListCommentResponseModel.class))
                .collect(Collectors.toList());
    }
}

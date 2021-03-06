package meng.xing.service;

import meng.xing.entity.Paper;
import meng.xing.entity.Subject;
import meng.xing.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/7/23.
 */
@Service
public class DefaultPaper implements PaperService {
    @Autowired
    PaperRepository paperRepository;


    @Override
    public Page<Paper> findAllPapersBySubject(Subject subject, Pageable pageable) {
        if (subject == null){
            return paperRepository.findAll(pageable);
        }
        return paperRepository.findBySubject(subject,pageable);
    }

    @Override
    public Paper findPaperById(Long id) {
        return paperRepository.findOne(id);
    }

    @Override
    @Transactional
    public boolean addPaper(Paper paper) {
        if (paperRepository.save(paper) != null)
            return true;
        else return false;
    }

    @Override
    @Transactional
    public boolean updatePaper(Paper paper) {
        if (paperRepository.save(paper) != null)
            return true;
        else return false;
    }

    @Override
    @Transactional
    public boolean deletePaperById(Long id) {
        paperRepository.delete(id);
        return true;
    }

}

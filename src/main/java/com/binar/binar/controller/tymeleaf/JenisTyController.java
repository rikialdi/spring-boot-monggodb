package com.binar.binar.controller.tymeleaf;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Jenis;
import com.binar.binar.repository.JenisRepo;
import com.binar.binar.service.JenisService;
import com.binar.binar.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller ///
@RequestMapping("/v1/view/jenis")
public class JenisTyController {
    @Autowired
    public JenisService serviceJenis;

    @Autowired
    public JenisRepo repoJenis;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "Selamat Datang");
        return "index-jenis";
    }

    private final int ROW_PER_PAGE = 5;

    @GetMapping(value = "/list")
    public String getJeniss(Model model,
                              @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        List<Jenis> jeniss = new ArrayList<>();
        Pageable sortedByIdAsc = PageRequest.of(pageNumber - 1, ROW_PER_PAGE,
                Sort.by("id").ascending());
        repoJenis.findAll(sortedByIdAsc).forEach(jeniss::add);
        long count = repoJenis.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;
        model.addAttribute("jeniss", jeniss);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);
        return "jenis-list";
    }

    @GetMapping(value = {"/add"})
    public String showAddJenis(Model model) {
        Jenis jenis = new Jenis();
        model.addAttribute("add", true);
        model.addAttribute("jenis", jenis);
        return "jenis-edit";
    }

    @PostMapping(value = "/add")
    public String addJenis(Model model,
                            @ModelAttribute("jenis") Jenis jenis) {
        try {
            Jenis newJenis = serviceJenis.saveTymeleaf(jenis);
            return "redirect:/v1/view/jenis/" + String.valueOf(newJenis.getId());
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);
            return "jenis-edit";
        }
    }

    @GetMapping(value = {"/{jenisId}/edit"})
    public String showEditJenis(Model model, @PathVariable long jenisId) {
        Jenis jenis = null;
        try {
            jenis = serviceJenis.findByIdTymeleaf(jenisId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Jenis not found");
        }
        model.addAttribute("add", false);
        model.addAttribute("jenis", jenis);
        return "jenis-edit";
    }

    @PostMapping(value = {"/{jenisId}/edit"})
    public String updateJenis(Model model,
                               @PathVariable long jenisId,
                               @ModelAttribute("jenis") Jenis jenis) {
        try {
            jenis.setId(jenisId);
            serviceJenis.updateTymeleaf(jenis);
            return "redirect:/v1/view/jenis/" + String.valueOf(jenis.getId());
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", false);
            return "jenis-edit";
        }
    }

    @GetMapping(value = "/{jenisId}")
    public String getJenisById(Model model, @PathVariable long jenisId) {
        Jenis jenis = null;
        try {
            jenis = serviceJenis.findByIdTymeleaf(jenisId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Jenis not found");
        }
        model.addAttribute("jenis", jenis);
        return "jenis";
    }
}

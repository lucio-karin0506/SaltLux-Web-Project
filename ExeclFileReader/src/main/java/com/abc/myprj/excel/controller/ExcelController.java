package com.abc.myprj.excel.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.abc.myprj.vo.ProblemsVO;

@Controller
public class ExcelController {
	
	
	@RequestMapping(value="/excel", method=RequestMethod.GET)
	public String main() { // 1
		return "problemfileupload";
	}

	@RequestMapping(value="/excel/new", method=RequestMethod.POST)
	public String readExcel(@RequestParam("file") MultipartFile file, Model model)
			throws IOException {
		ArrayList<ProblemsVO> problemList = new ArrayList<ProblemsVO>();

		String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3
		
		if (!extension.equals("xlsx") && !extension.equals("xls")) {
			throw new IOException("엑셀파일만 업로드 해주세요.");
		}

		Workbook workbook = null;

		if (extension.equals("xlsx")) {
			workbook = new XSSFWorkbook(file.getInputStream());
		} else if (extension.equals("xls")) {
			workbook = new HSSFWorkbook(file.getInputStream());
		}

		Sheet worksheet = workbook.getSheetAt(0);
		
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) { // 4
			ProblemsVO problems = new ProblemsVO();
			DataFormatter formatter = new DataFormatter();
			Row row = worksheet.getRow(i); 
			if("".equals(formatter.formatCellValue(row.getCell(0)))) {//예외처리
				break;
			}else {
				problems.setProblemContent(formatter.formatCellValue(row.getCell(0))); 
				problems.setProblemCase(formatter.formatCellValue(row.getCell(1)));
				problems.setProblemAnswer(formatter.formatCellValue(row.getCell(2)));
			}
			
			problemList.add(problems);

		}
		model.addAttribute("problemList", problemList);

		return "problemlist";
	}
}

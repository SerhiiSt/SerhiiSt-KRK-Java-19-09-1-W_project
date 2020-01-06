package pl.academy.schedule.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.academy.schedule.generator.Lesson;
import pl.academy.schedule.generator.Schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class WorkbookCreator {
    public Workbook createWorkbook(Schedule schedule) {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Lessons");


        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) workbook.createCellStyle();
        XSSFFont xssfFont = (XSSFFont) workbook.createFont();
        xssfFont.setBold(true);
        xssfCellStyle.setFont(xssfFont);


        CellStyle cellDateStyle = workbook.createCellStyle();
        CreationHelper createDateHelper = workbook.getCreationHelper();
        cellDateStyle.setDataFormat(createDateHelper.createDataFormat().getFormat("dd.mm.yyyy"));

        CellStyle cellTimeStyle = workbook.createCellStyle();
        CreationHelper createTimeHelper = workbook.getCreationHelper();
        cellTimeStyle.setDataFormat(createTimeHelper.createDataFormat().getFormat("HH:MM"));


        List<Lesson> lessons = schedule.getLessons();
        for (int i = 0; i < lessons.size(); i++) {
            Lesson lesson = lessons.get(i);
            Row row = getOrCreateRow(sheet, i);

            Cell dateCell = row.createCell(0);
            dateCell.setCellValue(lesson.getDate());
            dateCell.setCellStyle(cellDateStyle);


            Cell beginTime = row.createCell(3);
            beginTime.setCellValue(createDateWithTime(lesson.getBeginTime()));
            beginTime.setCellStyle(cellTimeStyle);

            Cell endTime = row.createCell(4);
            endTime.setCellValue(createDateWithTime(lesson.getEndTime()));
            endTime.setCellStyle(cellTimeStyle);

            Cell lessonTime = row.createCell(5);
            int index = i + 1;
            String timeFormula = "E" + index + "-D" + index + "";
            lessonTime.setCellFormula("IF(B" + index + "=\"done\",HOUR(" + timeFormula + ") + MINUTE(" + timeFormula + ")/60,\"\")");

            Row rowHoursDone = getOrCreateRow(sheet, 0);
            Cell hoursDone = rowHoursDone.createCell(7);
            hoursDone.setCellValue("hours done");


            Row rowSumHours = getOrCreateRow(sheet, 0);
            Cell sumHours = rowSumHours.createCell(8);
            int indexSumHours = 1;
            sumHours.setCellFormula("SUM(F" + (indexSumHours++) + ":F" + lessons.size() + ")");

            Row rowHoursPlanned = getOrCreateRow(sheet, 1);
            Cell hoursPlanned = rowHoursPlanned.createCell(7);
            hoursPlanned.setCellValue("hours planned");

            Row rowHoursPlannedValue = getOrCreateRow(sheet, 1);
            Cell hoursPlannedValue = rowHoursPlannedValue.createCell(8);
            hoursPlannedValue.setCellValue(4.5);

            Row rowLessonsDone = getOrCreateRow(sheet, 3);
            Cell lessonsDone = rowLessonsDone.createCell(7);
            lessonsDone.setCellValue("lessons done");

            Cell lessonDoneValue = rowLessonsDone.createCell(8);
            int indexLessonDoneValue = 1;
            lessonDoneValue.setCellFormula("COUNTIF(B" + (indexLessonDoneValue++) + ":B" + lessons.size() + ",\"done\")");

            Row rowLessonsPlanned = getOrCreateRow(sheet, 4);
            Cell lessonsPlanned = rowLessonsPlanned.createCell(7);
            lessonsPlanned.setCellValue("lessons planned");

            Row rowLessonsPlannedValue = getOrCreateRow(sheet, 4);
            Cell lessonsPlannedValue = rowLessonsPlannedValue.createCell(8);
            lessonsPlannedValue.setCellValue(2);

            Row rowStatus = getOrCreateRow(sheet, rowHoursDone.getPhysicalNumberOfCells() + 3);
            Cell status = rowStatus.createCell(7);
            status.setCellStyle(xssfCellStyle);
            status.setCellValue("STATUS");


            Cell rowStatusValue = rowStatus.createCell(8);
            rowStatusValue.setCellStyle(xssfCellStyle);
            rowStatusValue.setCellFormula("IF(I1=I2,\"COMPLETED\",\"IN PROGRESS\")");

        }

        return workbook;
    }

    private LocalDateTime createDateWithTime(LocalTime localTime) {
        return LocalDateTime.of(LocalDate.now(), localTime);
    }

    private Row getOrCreateRow(Sheet sheet, int index) {
        return Optional.ofNullable(sheet.getRow(index)).orElseGet(() -> sheet.createRow(index));

//        Row row = sheet.getRow(index);
//        if(isNull(row)) {
//            row = sheet.createRow(index);
//        }
//        return row;
    }

}

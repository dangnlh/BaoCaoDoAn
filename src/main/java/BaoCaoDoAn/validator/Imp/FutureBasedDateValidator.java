package BaoCaoDoAn.validator.Imp;

import java.sql.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import BaoCaoDoAn.Entity.Report;
import BaoCaoDoAn.Service.User.Impl.ReportServiceImpl;
import BaoCaoDoAn.validator.FutureBasedDate;

public class FutureBasedDateValidator implements ConstraintValidator<FutureBasedDate, Report> {
	@Autowired
	private ReportServiceImpl reportService;
//	public boolean isValid(Date value, ConstraintValidatorContext context) {
//		// TODO Auto-generated method stub
//		boolean result = true;

//		return result;
//	}
	public boolean isValid(Report value, ConstraintValidatorContext context) {
		boolean result = false;
		if(value.getId()==0) {
			Date now = new Date(new java.util.Date().getTime());
			System.out.println("NOW AND DEAD:"+now.after(value.getTimeSubmit()));
			if(!now.after(value.getTimeSubmit())) {
				result = true;
			}
		}else {
			Report fullReport = reportService.getReport(value.getId());
			Date createTime = fullReport.getTimeCreate();
			System.out.println("DATE CRE:"+createTime);
			Date deadline = value.getTimeSubmit();
			System.out.println("DATE DEAD:"+deadline);
			System.out.println(!createTime.after(deadline));
			if (!createTime.after(deadline)) {
				result = true;
			}
		}
		
		return result;
	}

}
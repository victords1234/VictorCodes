package com.crm.vtiger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.crm.comcast.objectRepoUtility.HomePage;
import com.crm.comcast.objectRepoUtility.OpportunitiesPage;
import com.vtigercrm.genericutilities.BaseClass;

public class DropDownWithoutSelect extends BaseClass{
	@Test
	public void test()
	{
		HomePage hp=new HomePage(driver);
		hp.getCreateOpportunity().click();

		OpportunitiesPage op=new OpportunitiesPage(driver);
		Select s=new Select(op.getInDropDown());
		Map<String,Integer> l1=new HashMap<String, Integer>();
		System.out.println(s.getFirstSelectedOption().getText());
		List<WebElement> opt = s.getOptions();
		String last = opt.get(opt.size()).getText();
		System.out.println(last);
		for(WebElement wb:opt)
		{
			if(l1.containsKey(wb))
			{
				l1.put(wb.getText(),l1.get(wb)+1);
			}
			else
			{
				l1.put(wb.getText(),1);
			}
		}
		Set<String> words = l1.keySet();
		for(String word:words)
		{
			if(l1.get(word)>1)
			{
				System.out.println(word);
			}
			else 
			{
				System.out.println("No Duplicates");
			}
		}
	}
}
package com.fridgeCare.fri.controller.jooRecipe;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.vo.ResipeAddVO;
import com.oreilly.servlet.MultipartRequest;

public class BoardAddProc implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "";
		
		return view;
	}
	// ���� ó�� �Լ�
			public ArrayList<ResipeAddVO> getFileInfo(String id, MultipartRequest multi) {
				ArrayList<ResipeAddVO> list = new ArrayList<ResipeAddVO>();
				/*
					MultipartRequest ��  ���� ���� �Լ�
					
						1. String getOriginalFilename("Ű��")
							==> ���ε��ϴ� ���� �� �̸��� �����ִ� �Լ�
						2. String getFilesystemName("Ű��")
							==> ���ε��ϴ� ������ ������ ����� �̸��� �����ִ� �Լ�
						3. Enumeration getFileNames()
							==> ���ε��ϴ� ���ϵ��� Ű������ Enumeration ���� ��ȯ���ش�.
						4 String[] getParameterValues("Ű��")
							==> �ϳ��� Ű������ ���޵Ǵ� �Ķ���͸� �迭���·� ��ȯ���ش�.
						5. String[]  getParameterNames()
							==> �Ķ���� Ű������ ���ڿ��迭�� ��ȯ���ش�.
							
				 */
				
				Enumeration en = multi.getFileNames();
				
				while(en.hasMoreElements()) {
					String name = (String) en.nextElement();
					
					String oriname = multi.getOriginalFileName(name);
					
					// �ƹ��͵� ���� �ȵ� �����±״� �ǳʶڴ�.
					if(oriname == null) continue;
					
					String savename = multi.getFilesystemName(name);
					File file = multi.getFile(name);
					long len = file.length();
					
					ResipeAddVO fVO = new ResipeAddVO();
					fVO.setId(id);
					fVO.setOriname(oriname);
					fVO.setTname(savename);
					fVO.setLen(len);
					
					// ����Ʈ�� VO �ϳ��� ���
					list.add(fVO);
				}
				
				return list;
			}
}

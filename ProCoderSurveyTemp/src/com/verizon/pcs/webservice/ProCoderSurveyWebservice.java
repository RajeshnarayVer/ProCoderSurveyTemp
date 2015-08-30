package com.verizon.pcs.webservice;

public class ProCoderSurveyWebservice{
	
/*
		long strtTm = System.currentTimeMillis();
		Response response = null;
		logger.debug("IssueTrackerWebservice :: getJITDashBoardHeader begins: "+ strtTm);
		logger.debug("IssueTrackerWebservice :: request : "+ request);
		StatusInfoTpye requeststatus = new StatusInfoTpye();
		String result = "";
		trackerUtil = new IssueTrackerUtil();
		String Vzid = "";
		JITDashBoardResponse dashBoardResp  =new JITDashBoardResponse();
		if (request != null && !request.isEmpty()) {
			try {
				issueTrackerService = new IssueTrackerServiceImpl();				
				JITDashBoardRequest dashBoardRequest = trackerUtil.readDashBoardReq(request);
				
				Vzid = dashBoardRequest.getVzid();
				if(dashBoardRequest!=null){
				if (Vzid!= null && Vzid!="" && Vzid.length()==7) {
				 dashBoardResp = issueTrackerService.getJITDashBoardHeader(Vzid);
				 if(dashBoardResp.getStatusInfo().getStatusCode()==0){
					requeststatus.setStatusCode(0);
					requeststatus.setStatusDesc("Request processed Successfully");
				 }
				 else
				 {
					requeststatus.setStatusCode(1001);
					requeststatus.setStatusDesc("Error in processing the request");
				 }
				 
				} else {
					requeststatus.setStatusCode(1);
					requeststatus.setStatusDesc("Not a Proper Request,Please enter a valid vzid ");
				}
				}
				else{
					requeststatus.setStatusCode(1);
					requeststatus.setStatusDesc("Invalid request format");
				}

			} catch (Exception e) {

				requeststatus.setStatusCode(1);
				requeststatus.setStatusDesc("Error Occured:Cannot process the request");
				exceptionLogService.insertCXMException(e, Vzid, AuditConstants.MODULE_NAME, AuditConstants.SUB_MODULE_ISSUETRACKER);
				logger.error("Exception occurred " + e);			   
			}

		} else {

			requeststatus.setStatusCode(1);
			requeststatus.setStatusDesc("Not a Proper Request  , Please Check and Resubmit the Request for JITDashBoardHeader ");
		}
		
		dashBoardResp.setStatusInfo(requeststatus);

		long endTm = System.currentTimeMillis();

		logger.debug("IssueTrackerWebservice :: getJITDashBoardHeader ends:"
				+ ((endTm - strtTm) / 1000) + " Secs");

		Long responseTime = ((endTm - strtTm) / 1000);

		auditCreateService.insertCXMAudit(Vzid,
				"/jobIssue/getJITDashBoardHeader", AuditConstants.MODULE_NAME,
				AuditConstants.SUB_MODULE_ISSUE, responseTime.toString(),
				"Request For JITDashBoardHeader");
		response = Response
				.ok(dashBoardResp)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();

		return response;

	
}
//READING REQUEST CODE BELOW
public SupervisorJIT readXmlgetSupervisorJIT(String reqXML) throws TmServiceException{
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder documentBuilder = null;
		String vzId = "";
		SupervisorJIT supervisorJIT = new SupervisorJIT();
		
		try{
		
			
			if(reqXML != null && reqXML.indexOf("CXM_JIT_REQUEST")!=-1 ){
			
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			InputStream inputStream = new ByteArrayInputStream(reqXML.getBytes());
			Document document = documentBuilder.parse(inputStream);

			NodeList nodeList;
			
			nodeList = document.getElementsByTagName("CXM_JIT_REQUEST");
			Element element = (Element) nodeList.item(0);
			
			if (getTextValue(element, "ISSUE_NAME") != null && getTextValue(element, "ISSUE_NAME") != "") {
				supervisorJIT.setIssueName(getTextValue(element, "ISSUE_NAME"));
			}else
				supervisorJIT.setIssueName(null);
			
			if (getTextValue(element, "JUR") != null && getTextValue(element, "JUR") != "") {
				supervisorJIT.setJur(getTextValue(element, "JUR"));
			}else
				supervisorJIT.setJur(null);
			
			if (getTextValue(element, "EWO_NUMBER") != null && getTextValue(element, "EWO_NUMBER") != "") {
				supervisorJIT.setEwoNumber(getTextValue(element, "EWO_NUMBER"));
			}else
				supervisorJIT.setEwoNumber(null);
				
			
			if (getTextValue(element, "WIRE_CENTER") != null && getTextValue(element, "WIRE_CENTER") != "") {
				supervisorJIT.setWireCenter(getTextValue(element, "WIRE_CENTER"));
			}else
				supervisorJIT.setWireCenter(null);
			
			if (getTextValue(element, "CTRL_NO") != null && getTextValue(element, "CTRL_NO") != "") {
				supervisorJIT.setCtrlNo(getTextValue(element, "CTRL_NO"));
			}else
				supervisorJIT.setCtrlNo(null);
			
			if (getTextValue(element, "JOB_ID") != null && getTextValue(element, "JOB_ID") != "") {
				supervisorJIT.setJobId(Integer.parseInt(getTextValue(element, "JOB_ID")));
			}else
				supervisorJIT.setJobId(0);
			
			if(getTextValue(element, "JOB_ISSUE_ID") != null && getTextValue(element, "JOB_ISSUE_ID") != "") {
				supervisorJIT.setJobIssueId(Integer.parseInt(getTextValue(element, "JOB_ISSUE_ID")));
			}else
				supervisorJIT.setJobIssueId(0);
		
			if(reqXML != null && reqXML.indexOf("PACKAGE_LIST")!=-1 ){
			
			NodeList nodeList1;
			nodeList1 = element.getElementsByTagName("PACKAGE_LIST");
			
			
			Element  element1=(Element) nodeList1.item(0);
			NodeList nodeList01=element1.getElementsByTagName("PACKAGES");
			if(reqXML != null && reqXML.indexOf("PACKAGES")!=-1 ){
			int i = nodeList01.getLength();
			String packages[]= new String[i];
			for(int j=0;j<packages.length;j++)
			{
			Element element01 = (Element) nodeList1.item(0);
			if (getTextValue(element01, "PACKAGES") != null && getTextValue(element01, "PACKAGES") != "") {
				String PACKAGES = getTextValue(element01, "PACKAGES");
				packages[j]=PACKAGES;
			}
			}
            supervisorJIT.setPackagesArr(packages);
			}
			}
            
            
            NodeList nodeList2;
			nodeList2 = element.getElementsByTagName("WORK_PRINTS_LIST");
			if(reqXML != null && reqXML.indexOf("WORK_PRINTS_LIST")!=-1 ){
			
            Element  element2=(Element) nodeList2.item(0);
			NodeList nodeList02=element2.getElementsByTagName("WORK_PRINTS");
			if(reqXML != null && reqXML.indexOf("WORK_PRINTS")!=-1 ){
			int a = nodeList02.getLength();
			String workPrints[]= new String[a];
			for(int b=0;b<workPrints.length;b++)
			{
			Element element02 = (Element) nodeList2.item(0);
			if (getTextValue(element02, "WORK_PRINTS") != null && getTextValue(element02, "WORK_PRINTS") != "") {
				String WORK_PRINTS = getTextValue(element02, "WORK_PRINTS");
				workPrints[b]=WORK_PRINTS;
			}
			}
            supervisorJIT.setWorkPrintsArr(workPrints);
			}
			}
            
            
            NodeList nodeList3;
			nodeList3 = element.getElementsByTagName("ACTIVITIES_LIST");
			if(reqXML != null && reqXML.indexOf("ACTIVITIES_LIST")!=-1 ){
            
            Element  element3=(Element) nodeList3.item(0);
			NodeList nodeList03=element3.getElementsByTagName("ACTIVITIES");
			if(reqXML != null && reqXML.indexOf("ACTIVITIES")!=-1 ){
			int c = nodeList03.getLength();
			String activities[]= new String[c];
			for(int d=0;d<activities.length;d++)
			{
			Element element03 = (Element) nodeList3.item(0);
			if (getTextValue(element03, "ACTIVITIES") != null && getTextValue(element03, "ACTIVITIES") != "") {
				String ACTIVITIES = getTextValue(element03, "ACTIVITIES");
				activities[d]=ACTIVITIES;
			}
			}
            supervisorJIT.setActivitiesArr(activities);
			}
			}
            
            
            if(getTextValue(element, "CATEGORY") != null && getTextValue(element, "CATEGORY") != "") {
				supervisorJIT.setCategory(getTextValue(element, "CATEGORY"));
			}else
				supervisorJIT.setCategory(null);
            
            if(getTextValue(element, "TYPE") != null && getTextValue(element, "TYPE") != "") {
				supervisorJIT.setIssueType(getTextValue(element, "TYPE"));
			}else
				supervisorJIT.setIssueType(null);
		
            if(getTextValue(element, "PRIORITY") != null && getTextValue(element, "PRIORITY") != "") {
				supervisorJIT.setPriority(getTextValue(element, "PRIORITY"));
			}else
				supervisorJIT.setPriority(null);
		
            if(getTextValue(element, "JOB_ISSUE_GROUP") != null && getTextValue(element, "JOB_ISSUE_GROUP") != "") {
				supervisorJIT.setJobIssueGroup(getTextValue(element, "JOB_ISSUE_GROUP"));
			}else
				supervisorJIT.setJobIssueGroup(null);
            
            if(getTextValue(element, "JOB_ISSUE_CREATE_DATE") != null && getTextValue(element, "JOB_ISSUE_CREATE_DATE") != "") {
				supervisorJIT.setJobIssueCreateDate(getTextValue(element, "JOB_ISSUE_CREATE_DATE"));
			}else
				supervisorJIT.setJobIssueCreateDate(null);
		
            if(getTextValue(element, "IDENTIFIED_BY") != null && getTextValue(element, "IDENTIFIED_BY") != "") {
				supervisorJIT.setIdentifiedBy(getTextValue(element, "IDENTIFIED_BY"));
			}else
				supervisorJIT.setIdentifiedBy(null);
            
            if(getTextValue(element, "REFERRED_TO") != null && getTextValue(element, "REFERRED_TO") != "") {
				supervisorJIT.setReferredTo(getTextValue(element, "REFERRED_TO"));
				
			}else
				supervisorJIT.setReferredTo(null);
            
            if(getTextValue(element, "ISSUE_STATUS") != null && getTextValue(element, "ISSUE_STATUS") != "") {
				supervisorJIT.setIssueStatus(getTextValue(element, "ISSUE_STATUS"));
			}else
				supervisorJIT.setIssueStatus(null);
            
            if(getTextValue(element, "JOB_ISSUE_CLOSE_DATE") != null && getTextValue(element, "JOB_ISSUE_CLOSE_DATE") != "") {
				supervisorJIT.setJobIssueCloseDate(getTextValue(element, "JOB_ISSUE_CLOSE_DATE"));
			}else
				supervisorJIT.setJobIssueCloseDate(null);
            
            if(getTextValue(element, "JOB_ISSUE_DESC") != null && getTextValue(element, "JOB_ISSUE_DESC") != "") {
				supervisorJIT.setJobIssueDesc(getTextValue(element, "JOB_ISSUE_DESC"));
			}else
				supervisorJIT.setJobIssueDesc(null);
            
            NodeList nodeList4;
			nodeList4 = element.getElementsByTagName("ASSIGN_TO_LIST");
			if(reqXML != null && reqXML.indexOf("ASSIGN_TO_LIST")!=-1 ){
            Element  element4=(Element) nodeList4.item(0);
			NodeList nodeList04=element4.getElementsByTagName("ASSIGN_TO_USER");
			if(reqXML != null && reqXML.indexOf("ASSIGN_TO_USER")!=-1 ){
			int e = nodeList04.getLength();
			String assignToUser[]= new String[e];
			for(int f=0;f<assignToUser.length;f++)
			{
			Element element04 = (Element) nodeList4.item(0);
			if (getTextValue(element04, "ASSIGN_TO_USER") != null && getTextValue(element04, "ASSIGN_TO_USER") != "") {
				String ASSIGN_TO_USER = getTextValue(element04, "ASSIGN_TO_USER");
				assignToUser[f]=ASSIGN_TO_USER;
			}
			}
            supervisorJIT.setAssignToListArr(assignToUser);
			}
			}
            
            
            
            NodeList nodeList5;
			nodeList5 = element.getElementsByTagName("STEPS_ASSIGN_LIST");
			if(reqXML != null && reqXML.indexOf("STEPS_ASSIGN_LIST")!=-1 ){
            Element  element5=(Element) nodeList5.item(0);
			NodeList nodeList05=element5.getElementsByTagName("STEPS_ASSIGN_TO");
			if(reqXML != null && reqXML.indexOf("STEPS_ASSIGN_TO")!=-1 ){
			int g = nodeList05.getLength();
			String assignToList[]= new String[g];
			for(int h=0;h<assignToList.length;h++)
			{
			Element element05 = (Element) nodeList5.item(0);
			if (getTextValue(element05, "STEPS_ASSIGN_TO") != null && getTextValue(element05, "STEPS_ASSIGN_TO") != "") {
				String STEPS_ASSIGN_TO = getTextValue(element05, "STEPS_ASSIGN_TO");
				assignToList[h]=STEPS_ASSIGN_TO;
			}
			}
            supervisorJIT.setStepsAssignListArr(assignToList);
			}
			}
		
            if(getTextValue(element, "RESPONSE") != null && getTextValue(element, "RESPONSE") != "") {
				supervisorJIT.setResponse(getTextValue(element, "RESPONSE"));
			}else
				supervisorJIT.setResponse(null);
            
            if(getTextValue(element, "VZID") != null && getTextValue(element, "VZID") != "") {
				supervisorJIT.setVzId(getTextValue(element, "VZID"));
			}else
				supervisorJIT.setVzId(null);
            
            if(getTextValue(element, "ACTION") != null && getTextValue(element, "ACTION") != "") {
				supervisorJIT.setAction(getTextValue(element, "ACTION"));
			}else
				supervisorJIT.setAction(null);
           
            	System.out.println("actionn:"+supervisorJIT.getAction());
            
            if(getTextValue(element, "MODULE_ID") != null && getTextValue(element, "MODULE_ID") != "") {
				supervisorJIT.setModuleId(Integer.parseInt(getTextValue(element, "MODULE_ID")));
			}else
				supervisorJIT.setModuleId(0);
			}
            
            else{
				 logger.debug("Improper Request");
				 throw new TmServiceException("Improper Request" , 1001);
		        }
		}
		catch (SAXException e) {
			exceptionLogService.insertCXMException(e, TmValUtil.vzId, AuditConstants.MODULE_NAME, AuditConstants.SUB_MODULE_ISSUETRACKER);
			logger.error("error:",e);
		} catch (IOException e) {
			exceptionLogService.insertCXMException(e, TmValUtil.vzId, AuditConstants.MODULE_NAME, AuditConstants.SUB_MODULE_ISSUETRACKER);
			 logger.error("error:",e);
		} catch (ParserConfigurationException e) {
			exceptionLogService.insertCXMException(e, TmValUtil.vzId, AuditConstants.MODULE_NAME, AuditConstants.SUB_MODULE_ISSUETRACKER);
			 logger.error("error:",e);
		} catch (NullPointerException e) {
			exceptionLogService.insertCXMException(e, TmValUtil.vzId, AuditConstants.MODULE_NAME, AuditConstants.SUB_MODULE_ISSUETRACKER);
			 logger.error("error:",e);
		} catch (TmServiceException te){
			exceptionLogService.insertCXMException(te, TmValUtil.vzId, AuditConstants.MODULE_NAME, AuditConstants.SUB_MODULE_ISSUETRACKER);
			 throw new TmServiceException(te.getErrorDesc(), te.getErrorCode());
		}
		catch(Exception e ){
			 logger.error("error:",e);
		 }
		
		return supervisorJIT;
		*/
	}

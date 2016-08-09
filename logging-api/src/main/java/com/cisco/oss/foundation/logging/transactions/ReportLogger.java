package com.cisco.oss.foundation.logging.transactions;

import org.slf4j.Logger;

/**
 * Created by Nuna on 10/01/2016.
 */
public class ReportLogger extends SchedulerLogger {

    public static void start(final Logger logger, final Logger auditor, final String reportName) {
        if(!createLoggingAction(logger, auditor, new ReportLogger())) {
            return;
        }

        ReportLogger reportLogger = (ReportLogger) getInstance();
        if (reportLogger == null) {
            return;
        }

        reportLogger.startInstance(reportName);
    }


    @Override
    protected void addPropertiesStart(String reportName) {
        super.addPropertiesStart("Report", "ReportName", reportName);
    }

    public static void success(String reportBody) {
        ReportLogger logger = (ReportLogger) getInstance();
        if (logger == null) {
            return;
        }

        addProperty("ReportBody", reportBody);

        logger.successInstance();

    }
}

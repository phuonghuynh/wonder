// _ERCMailMessage.java
//
// Created by eogenerator
// DO NOT EDIT.  Make changes to ERCMailMessage.java instead.
package er.corebusinesslogic;
import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.eof.ERXGenericRecord;
import er.extensions.foundation.ERXCompressionUtilities;

public abstract class _ERCMailMessage extends ERCStampedEnterpriseObject {

    public static Logger log = Logger.getLogger(_ERCMailMessage.class);
    
    public _ERCMailMessage() {
        super();
    }

    public static abstract class _ERCMailMessageClazz extends ERXGenericRecord.ERXGenericRecordClazz {

        public NSArray messagesToBeSent(EOEditingContext ec) {
            return EOUtilities.objectsWithFetchSpecificationAndBindings(ec, "ERCMailMessage", "messagesToBeSent", null);
        }

        public NSArray ripeMessagesWithDate(EOEditingContext ec, Object date) {
            NSMutableDictionary _dict = new NSMutableDictionary(2);

            if(date != null) _dict.setObjectForKey( date, "date");
            return EOUtilities.objectsWithFetchSpecificationAndBindings(ec, "ERCMailMessage", "ripeMessages", _dict);
        }

    }

    public boolean contentGzippedAsBoolean() {
        return contentGzipped() != null && contentGzipped().booleanValue();
    }
    
    public Boolean contentGzipped() {
        return (Boolean)storedValueForKey("contentGzipped");
    }

    public void setContentGzipped(Boolean aValue) {
        takeStoredValueForKey(aValue, "contentGzipped");
    }
    
    public String contextString() {
        return (String)storedValueForKey("contextString");
    }

    public void setContextString(String contextString) {
        takeStoredValueForKey(contextString, "contextString");
    }

    public Boolean shouldArchiveSentMail() {
        return (Boolean)storedValueForKey("shouldArchiveSentMail");
    }

    public void setShouldArchiveSentMail(Boolean aValue) {
        takeStoredValueForKey(aValue, "shouldArchiveSentMail");        
    }
    
    public String fromAddress() {
        return (String)storedValueForKey("fromAddress");
    }
    public void setFromAddress(String aValue) {
        takeStoredValueForKey(aValue, "fromAddress");
    }

    public String toAddresses() {
        return (String)storedValueForKey("toAddresses");
    }
    public void setToAddresses(String aValue) {
        takeStoredValueForKey(aValue, "toAddresses");
    }

    public String ccAddresses() {
        return (String)storedValueForKey("ccAddresses");
    }
    public void setCcAddresses(String aValue) {
        takeStoredValueForKey(aValue, "ccAddresses");
    }

    public String bccAddresses() {
        return (String)storedValueForKey("bccAddresses");
    }
    public void setBccAddresses(String aValue) {
        takeStoredValueForKey(aValue, "bccAddresses");
    }

    public String title() {
        return (String)storedValueForKey("title");
    }
    public void setTitle(String aValue) {
        takeStoredValueForKey(aValue, "title");
    }

    public String exceptionReason() {
        return (String)storedValueForKey("exceptionReason");
    }
    
    public void setExceptionReason(String aValue) {
        takeStoredValueForKey(aValue, "exceptionReason");
    }    
    
    public String text() {
        String value = null;
        if (contentGzippedAsBoolean()) {
            value = (String)storedGzippedValueForKey("textCompressed");
        } else {
            value = (String)storedValueForKey("text");
        }
        return value;
    }
    public void setText(String aValue) {
        if (contentGzippedAsBoolean()) {
            takeStoredGzippedValueForKey(aValue, "textCompressed");
        } else {
            takeStoredValueForKey(aValue, "text");            
        }
    }

    public String plainText() {
        String value = null;
        if (contentGzippedAsBoolean()) {
            value = storedGzippedValueForKey("plainTextCompressed");
        } else {
            value = (String)storedValueForKey("plainText");
        }
        return value;
    }

    public void setPlainText(String aValue) {
        if (contentGzippedAsBoolean()) {
            takeStoredGzippedValueForKey(aValue, "plainTextCompressed");
        } else {
            takeStoredValueForKey(aValue, "plainText");            
        }        
    }    
    
    public String storedGzippedValueForKey(String key) {
        NSData data = (NSData)storedValueForKey(key);
        String value = null;
        if (data != null && data.bytes().length > 0) {
            value = ERXCompressionUtilities.gunzipByteArrayAsString(data.bytes());
        }
        return value;
    }

    public void takeStoredGzippedValueForKey(String aValue, String key) {
        byte bytes[] = ERXCompressionUtilities.gzipStringAsByteArray(aValue);
        if (bytes.length > 0) {
            takeStoredValueForKey(new NSData(bytes), key);
        }
    }
    
    public NSTimestamp dateSent() {
        return (NSTimestamp)storedValueForKey("dateSent");
    }
    public void setDateSent(NSTimestamp aValue) {
        takeStoredValueForKey(aValue, "dateSent");
    }

    public String replyToAddress() {
        return (String)storedValueForKey("replyToAddress");
    }
    public void setReplyToAddress(String aValue) {
        takeStoredValueForKey(aValue, "replyToAddress");
    }

    public String xMailer() {
        return (String)storedValueForKey("xMailer");
    }
    public void setXMailer(String aValue) {
        takeStoredValueForKey(aValue, "xMailer");
    }

    public String contentType() {
        return (String)storedValueForKey("contentType");
    }
    public void setContentType(String aValue) {
        takeStoredValueForKey(aValue, "contentType");
    }

    public Number isRead() {
        return (Number)storedValueForKey("isRead");
    }
    public void setIsRead(Number aValue) {
        takeStoredValueForKey(aValue, "isRead");
    }

    public ERCMailState state() {
        return (ERCMailState)storedValueForKey("state");
    }

    public void setState(ERCMailState aValue) {
        takeStoredValueForKey(aValue, "state");
    }
    public void addToBothSidesOfState(ERCMailState object) {
        addObjectToBothSidesOfRelationshipWithKey(object, "state");
    }
    public void removeFromBothSidesOfState(ERCMailState object) {
        removeObjectFromBothSidesOfRelationshipWithKey(object, "state");
    }


    public NSArray attachments() {
        return (NSArray)storedValueForKey("attachments");
    }
    public void setAttachments(NSMutableArray aValue) {
        takeStoredValueForKey(aValue, "attachments");
    }
    
    public void addToAttachments(ERCMessageAttachment object) {
        includeObjectIntoPropertyWithKey(object, "attachments");
    }
    
    public void removeFromAttachments(ERCMessageAttachment object) {
        removeObjectFromPropertyWithKey(object, "attachments");
    }
    
    public void addToBothSidesOfAttachments(ERCMessageAttachment object) {
        addObjectToBothSidesOfRelationshipWithKey(object, "attachments");
    }
    public void removeFromBothSidesOfAttachments(ERCMessageAttachment object) {
        removeObjectFromBothSidesOfRelationshipWithKey(object, "attachments");
    }

}
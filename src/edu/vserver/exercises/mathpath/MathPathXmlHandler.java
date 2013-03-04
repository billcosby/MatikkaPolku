package edu.vserver.exercises.mathpath;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import edu.vserver.exercises.helpers.XMLHelper;
import edu.vserver.exercises.model.ExerciseException;
import edu.vserver.exercises.model.ExerciseXMLHandler;

public class MathPathXmlHandler implements
ExerciseXMLHandler<MathPathExerciseData> {

	public static final MathPathXmlHandler INSTANCE = new MathPathXmlHandler();

	@Override
	public InputStream save(MathPathExerciseData etd) throws ExerciseException {
		 InputStream result = null;
		 
		 try {
			 Document doc = XMLHelper.createEmptyDocument();
			 Element root = doc.createElement("mathpath-exercise");
			 doc.appendChild(root);
			 
			 root.setAttribute("amountOfOptions", etd.getAmountOfOptions() + "");
			 root.setAttribute("minValue", etd.getMin() + "");
			 root.setAttribute("maxValue", etd.getMax() + "");
			 root.setAttribute("pathLength", etd.getPathLength() + "");
			 
			 result = XMLHelper.xmlToInputStream(doc);
			 
		 } catch (ParserConfigurationException e) {
				throw new ExerciseException(
						ExerciseException.ErrorType.XML_WRITE_ERROR, e);
			} catch (TransformerConfigurationException e) {
				throw new ExerciseException(
						ExerciseException.ErrorType.XML_WRITE_ERROR, e);
			} catch (TransformerException e) {
				throw new ExerciseException(
						ExerciseException.ErrorType.XML_WRITE_ERROR, e);
			} catch (TransformerFactoryConfigurationError e) {
				throw new ExerciseException(
						ExerciseException.ErrorType.XML_WRITE_ERROR, e);
			}
		
		
		
		return result;
	}

	@Override
	public MathPathExerciseData load(InputStream inStream)
			throws ExerciseException {
		MathPathExerciseData res = null;

		try {

			Document doc = XMLHelper.parseFromStream(inStream);

			doc.getDocumentElement().normalize();

			String amountAttribute = doc.getDocumentElement().getAttribute(
					"amountOfOptions");
			String minAttribute = doc.getDocumentElement().getAttribute("minValue");
			String maxAttribute = doc.getDocumentElement().getAttribute("maxValue");
			String lengthAttribute = doc.getDocumentElement().getAttribute("pathLength");
			
			int parsedAmount = Integer.parseInt(amountAttribute);
			int parsedMin = Integer.parseInt(minAttribute);
			int parsedMax = Integer.parseInt(maxAttribute);
			int parsedLength = Integer.parseInt(lengthAttribute);

			res = new MathPathExerciseData(parsedMin, parsedMax, parsedAmount, parsedLength);

		} catch (ParserConfigurationException e) {
			throw new ExerciseException(
					ExerciseException.ErrorType.XML_LOAD_ERROR, e);
		} catch (SAXException e) {
			throw new ExerciseException(
					ExerciseException.ErrorType.XML_LOAD_ERROR, e);
		} catch (IOException e) {
			throw new ExerciseException(
					ExerciseException.ErrorType.XML_LOAD_ERROR, e);
		}

		return res;
	}


}

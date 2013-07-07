package in.careerscale.apps.ocms.dao.model;

// Generated Jul 7, 2013 10:49:55 AM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * DocumentType generated by hbm2java
 */
@Entity
@Table(name = "document_type", catalog = "ocms")
public class DocumentType implements java.io.Serializable {

	private Integer id;
	private CaseType caseType;
	private String supportedFormats;
	private Boolean isMandatory;
	private Integer maxSize;
	private String name;
	private Set documentOptionses = new HashSet(0);
	private Set caseArtifacts = new HashSet(0);
	private Set caseDiscussions = new HashSet(0);

	public DocumentType() {
	}

	public DocumentType(CaseType caseType, String supportedFormats,
			Boolean isMandatory, Integer maxSize, String name,
			Set documentOptionses, Set caseArtifacts, Set caseDiscussions) {
		this.caseType = caseType;
		this.supportedFormats = supportedFormats;
		this.isMandatory = isMandatory;
		this.maxSize = maxSize;
		this.name = name;
		this.documentOptionses = documentOptionses;
		this.caseArtifacts = caseArtifacts;
		this.caseDiscussions = caseDiscussions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "case_type_id")
	public CaseType getCaseType() {
		return this.caseType;
	}

	public void setCaseType(CaseType caseType) {
		this.caseType = caseType;
	}

	@Column(name = "supported_formats", length = 150)
	public String getSupportedFormats() {
		return this.supportedFormats;
	}

	public void setSupportedFormats(String supportedFormats) {
		this.supportedFormats = supportedFormats;
	}

	@Column(name = "is_mandatory")
	public Boolean getIsMandatory() {
		return this.isMandatory;
	}

	public void setIsMandatory(Boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	@Column(name = "max_size")
	public Integer getMaxSize() {
		return this.maxSize;
	}

	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "documentType")
	public Set<DocumentOptions> getDocumentOptionses()
	{
		return this.documentOptionses;
	}

	public void setDocumentOptionses(Set<DocumentOptions> documentOptionses)
	{
		this.documentOptionses = documentOptionses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "documentType")
	public Set<CaseArtifact> getCaseArtifacts()
	{
		return this.caseArtifacts;
	}

	public void setCaseArtifacts(Set<CaseArtifact> caseArtifacts)
	{
		this.caseArtifacts = caseArtifacts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "documentType")
	public Set<CaseDiscussion> getCaseDiscussions()
	{
		return this.caseDiscussions;
	}

	public void setCaseDiscussions(Set<CaseDiscussion> caseDiscussions)
	{
		this.caseDiscussions = caseDiscussions;
	}

}

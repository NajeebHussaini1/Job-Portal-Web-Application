import { Experience } from "./Experience";

export class Resume {
    resumeId: string;
    firstName! :string ;
    lastName! :string;
    primaryNumber? : string;
    userName! :string;
	email! :string;
	addressLine1! :string;
    addressLine2! :string;
    country! :string;
    state! :string;
    city! :string;
    highestLevelOfEducation! :string;
	experiences: Experience[];   
}
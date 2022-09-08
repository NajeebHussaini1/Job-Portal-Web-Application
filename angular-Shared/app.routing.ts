import { RouterModule } from "@angular/router";
import { DepartmentsComponent } from "../departments/departments.component";
import { HomeComponent } from "../home/home.component";
import { LocationComponent } from "../location/location.component";
import { LoginComponent } from "../login/login.component";
import { ApplicantsComponent } from "../portal/employer-portal/applicants/applicants.component";
import { EmployerPortalComponent } from "../portal/employer-portal/employer-portal.component";
import { EmployersPostingsComponent } from "../portal/employer-portal/employers-postings/employers-postings.component";
import { JobDetailComponent } from "../portal/employer-portal/job-detail/job-detail.component";
import { PostingComponent } from "../portal/employer-portal/posting/posting.component";
import { AppliedjobsComponent } from "../portal/jobseeker-portal/appliedjobs/appliedjobs.component";
import { ApplyJobsComponent } from "../portal/jobseeker-portal/apply-jobs/apply-jobs.component";
import { ResumeComponent } from "../portal/jobseeker-portal/resume/resume.component";
import { PortalComponent } from "../portal/portal.component";
import { ProfileComponent } from "../profile/profile.component";

import { RegisterComponent } from "../register/register.component";
import { CanactivategaurdService } from "./canactivategaurd.service";

export const AppRouting = RouterModule.forRoot([
    {path:'', redirectTo:'home', pathMatch:'full'},
    {path:'Home', component:HomeComponent},
    {path:'portal', component:PortalComponent, canActivate: [CanactivategaurdService]},
    {path:'login', component:LoginComponent},
    {path:'register', component:RegisterComponent},
    {path:'Departments', component:DepartmentsComponent},
    {path:'EmployersPostings', component:EmployersPostingsComponent},
    {path:'PostJob', component:PostingComponent},
    {path:'resume', component:ResumeComponent},
    {path:'applyjobs',component:ApplyJobsComponent},
    {path:'appliedjobs',component:AppliedjobsComponent},
    {path:'profile', component:ProfileComponent},
    {path:'applicants',component:ApplicantsComponent},
    {path:'empPortal',component:EmployerPortalComponent},
    {path:'**', redirectTo:'Home'}
])
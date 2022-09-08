import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LocationComponent } from './location/location.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { PortalComponent } from './portal/portal.component';
import { PostingComponent } from './portal/employer-portal/posting/posting.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'; 

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule, MatLabel} from '@angular/material/form-field';
import {MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import { MatSelectModule} from '@angular/material/select'
import {MatToolbarModule} from '@angular/material/toolbar';
import { EmployerService } from './Shared/employer.service';
import { AdminService } from './Shared/admin.service';
import { JobseekerService } from './Shared/jobseeker.service';
import { JobdetailService } from './Shared/jobdetail.service';
import { ResumeService } from './Shared/resume.service';
import { CanactivategaurdService } from './Shared/canactivategaurd.service';
import { EmployerregisterComponent } from './register/employerregister/employerregister.component';
import { AdminregisterComponent } from './register/adminregister/adminregister.component';
import { JobseekerregisterComponent } from './register/jobseekerregister/jobseekerregister.component';
import { AppRouting } from './Shared/app.routing';
import { EmployerloginComponent } from './login/employerlogin/employerlogin.component';
import { AdminloginComponent } from './login/adminlogin/adminlogin.component';
import { JobseekerloginComponent } from './login/jobseekerlogin/jobseekerlogin.component';
import { DepartmentsComponent } from './departments/departments.component';
import { ResumeComponent } from './portal/jobseeker-portal/resume/resume.component';
import { LoggeduserService } from './Shared/loggeduser.service';
import { EmployerPortalComponent } from './portal/employer-portal/employer-portal.component';
import { EmployersPostingsComponent } from './portal/employer-portal/employers-postings/employers-postings.component';
import { JobItemComponent } from './portal/employer-portal/employers-postings/job-item.component';
import { JobDetailComponent } from './portal/employer-portal/job-detail/job-detail.component';
import { JobseekerPortalComponent } from './portal/jobseeker-portal/jobseeker-portal.component';
import { AdminPortalComponent } from './portal/admin-portal/admin-portal.component';
import { ApplyJobsComponent } from './portal/jobseeker-portal/apply-jobs/apply-jobs.component';
import { AppliedjobsComponent } from './portal/jobseeker-portal/appliedjobs/appliedjobs.component';
import { AppliedJobService } from './Shared/appliedJobs.service';
import { AllPostingsComponent } from './portal/employer-portal/all-postings/all-postings.component';
import { AllJobItemComponent } from './portal/employer-portal/all-postings/all-job-item.component';
import { AllJobDetailComponent } from './portal/employer-portal/all-job-detail/all-job-detail.component';
import { UpdateJobComponent } from './portal/employer-portal/update-job/update-job.component';
import { ProfileComponent } from './profile/profile.component';
import { ApplicantsComponent } from './portal/employer-portal/applicants/applicants.component';
import { ApplicantserviceService } from './Shared/applicantservice.service';





@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LocationComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    PortalComponent,
    PostingComponent,
    EmployerregisterComponent,
    AdminregisterComponent,
    JobseekerregisterComponent,
    EmployerloginComponent,
    AdminloginComponent,
    JobseekerloginComponent,
    DepartmentsComponent,
    ResumeComponent,
    EmployerPortalComponent,
    EmployersPostingsComponent,
    JobItemComponent,
    JobDetailComponent,
    JobseekerPortalComponent,
    AdminPortalComponent,
    ApplyJobsComponent,
    AppliedjobsComponent,
    AllJobItemComponent,
    AllPostingsComponent,
    AllJobDetailComponent,
    UpdateJobComponent,
    ProfileComponent,
    ApplicantsComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatListModule,
    MatIconModule,
    MatCardModule,
    MatToolbarModule,
    MatSelectModule,
    AppRouting
    
  ],
  providers: [EmployerService, AdminService, JobseekerService, JobdetailService, ResumeService, CanactivategaurdService, LoggeduserService,AppliedJobService, ApplicantserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }

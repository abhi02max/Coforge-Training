import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyDashboard } from './company-dashboard';

describe('CompanyDashboard', () => {
  let component: CompanyDashboard;
  let fixture: ComponentFixture<CompanyDashboard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompanyDashboard],
    }).compileComponents();

    fixture = TestBed.createComponent(CompanyDashboard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

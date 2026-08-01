import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Child2 } from './child2';

describe('Child2', () => {
  let component: Child2;
  let fixture: ComponentFixture<Child2>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Child2],
    }).compileComponents();

    fixture = TestBed.createComponent(Child2);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewloginformComponent } from './newregisterform.component';

describe('NewloginformComponent', () => {
  let component: NewloginformComponent;
  let fixture: ComponentFixture<NewloginformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewloginformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewloginformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

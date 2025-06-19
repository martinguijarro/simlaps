import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateLapComponent } from './create-lap.component';

describe('CreateLapComponent', () => {
  let component: CreateLapComponent;
  let fixture: ComponentFixture<CreateLapComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateLapComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateLapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

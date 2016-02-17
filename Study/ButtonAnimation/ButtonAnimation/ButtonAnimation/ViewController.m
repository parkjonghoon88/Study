//
//  ViewController.m
//  ButtonAnimation
//
//  Created by 박종훈 on 2016. 2. 9..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    self.view.backgroundColor = [UIColor whiteColor];

    UIButton *redButton = [UIButton buttonWithType:UIButtonTypeSystem];
    [redButton setTintColor:[UIColor redColor]];
    [redButton setTitle:@"redButton" forState:UIControlStateNormal];
    redButton.titleLabel.font = [UIFont systemFontOfSize:20];
    [redButton addTarget:self action:@selector(didTapButton:) forControlEvents:UIControlEventTouchUpInside];
    [redButton sizeToFit];
    
    [self.view addSubview:redButton];
    
    UIButton *blueButton = [UIButton buttonWithType:UIButtonTypeSystem];
    [blueButton setTintColor:[UIColor blueColor]];
    [blueButton setTitle:@"blueButton" forState:UIControlStateNormal];
    blueButton.titleLabel.font = [UIFont systemFontOfSize:20];
    [blueButton addTarget:self action:@selector(didTapButton:) forControlEvents:UIControlEventTouchUpInside];
    [blueButton sizeToFit];
        blueButton.frame = CGRectMake(CGRectGetWidth(self.view.frame) - CGRectGetWidth(blueButton.frame),
                                      0, CGRectGetWidth(blueButton.frame), CGRectGetHeight(blueButton.frame));
    
    [self.view addSubview:blueButton];
}

- (void)didTapButton:(UIButton *)button
{
    CGRect buttonFrame = button.frame;
    if (button.frame.origin.x == 0 && button.frame.origin.y == 0) {
        buttonFrame.origin.x = CGRectGetWidth(self.view.frame) - CGRectGetWidth(buttonFrame);
    } else if (button.frame.origin.y == 0) {
        buttonFrame.origin.y = CGRectGetHeight(self.view.frame) - CGRectGetHeight(buttonFrame);
    } else if (button.frame.origin.x == 0) {
        buttonFrame.origin = CGPointZero;
    } else {
        buttonFrame.origin.x = 0;
    }
    
    [UIView beginAnimations:nil context:NULL];
    button.frame = buttonFrame;
    [UIView commitAnimations];
}



@end

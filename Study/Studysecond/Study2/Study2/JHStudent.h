//
//  JHStudent.h
//  Study2
//
//  Created by 박종훈 on 2016. 1. 30..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface JHStudent : NSObject <NSCoding>

@property (nonatomic, retain, readonly) NSString* studentNo;
@property (nonatomic, assign) NSInteger studentJumsu;

@end

